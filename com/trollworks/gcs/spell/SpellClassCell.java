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

package com.trollworks.gcs.spell;

import com.trollworks.gcs.widgets.outline.ListRow;
import com.trollworks.gcs.widgets.outline.MultiCell;

/** A cell for displaying the spell class and college. */
public class SpellClassCell extends MultiCell {
	@Override
	protected String getPrimaryText(ListRow row) {
		return row.canHaveChildren() ? "" : ((Spell) row).getSpellClass(); //$NON-NLS-1$
	}

	@Override
	protected String getSecondaryText(ListRow row) {
		return row.canHaveChildren() ? "" : ((Spell) row).getCollege(); //$NON-NLS-1$
	}

	@Override
	protected String getSortText(ListRow row) {
		return getSecondaryText(row);
	}
}
