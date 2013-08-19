/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is GURPS Character Sheet.
 *
 * The Initial Developer of the Original Code is Richard A. Wilkes.
 * Portions created by the Initial Developer are Copyright (C) 1998-2002,
 * 2005-2009 the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *
 * ***** END LICENSE BLOCK ***** */

package com.trollworks.gcs.prereq;

import com.trollworks.gcs.widgets.outline.ListRow;
import com.trollworks.ttk.utility.LocalizedMessages;
import com.trollworks.ttk.widgets.BandedPanel;

/** Displays and edits {@link Prereq} objects. */
public class PrereqsPanel extends BandedPanel {
	private static String	MSG_PREREQUISITES;

	static {
		LocalizedMessages.initialize(PrereqsPanel.class);
	}

	/**
	 * Creates a new prerequisite editor.
	 * 
	 * @param row The row these prerequisites will belong to.
	 * @param prereqs The initial prerequisites to display.
	 */
	public PrereqsPanel(ListRow row, PrereqList prereqs) {
		super(MSG_PREREQUISITES);
		addPrereqs(row, new PrereqList(null, prereqs), 0);
	}

	/** @return The current prerequisite list. */
	public PrereqList getPrereqList() {
		return (PrereqList) ((ListPrereqEditor) getComponent(0)).getPrereq();
	}

	private void addPrereqs(ListRow row, PrereqList prereqs, int depth) {
		add(PrereqEditor.create(row, prereqs, depth++));
		for (Prereq prereq : prereqs.getChildren()) {
			if (prereq instanceof PrereqList) {
				addPrereqs(row, (PrereqList) prereq, depth);
			} else {
				add(PrereqEditor.create(row, prereq, depth));
			}
		}
	}
}
