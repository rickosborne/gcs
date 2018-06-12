#!/bin/bash

VERSION=4.11
LONG_VERSION=4.11.0-`date "+%Y%m%d%H%M%S"`
YEAR=`date "+%Y"`
BUILD_DIR=.build
MODULES_DIR=../java_modules

mkdir -p $MODULES_DIR
/bin/rm -rf $BUILD_DIR
/bin/rm -f $MODULES_DIR/com.trollworks.gcs*

mkdir $BUILD_DIR

javac -p $MODULES_DIR -d $BUILD_DIR $(find src -name '*.java')

echo "bundle-name: GCS" > .manifest.txt
echo "bundle-version: $LONG_VERSION" >> .manifest.txt
echo "bundle-license: Mozilla Public License 2.0" >> .manifest.txt
echo "bundle-copyright-owner: Richard A. Wilkes" >> .manifest.txt
echo "bundle-copyright-years: 1998-$YEAR" >> .manifest.txt
echo "bundle-executable: gcs" >> .manifest.txt
echo "bundle-id: com.trollworks.gcs" >> .manifest.txt
echo "bundle-signature: RWGS" >> .manifest.txt
echo "bundle-category: public.app-category.role-playing-games" >> .manifest.txt

jar --create --file $MODULES_DIR/com.trollworks.gcs@${VERSION}.jar --module-version ${VERSION} \
	--manifest .manifest.txt --main-class com.trollworks.gcs.app.GCS -C $BUILD_DIR . -C resources .

zip -r -9 -q $MODULES_DIR/com.trollworks.gcs@${VERSION}-src.zip src resources

/bin/rm -rf $BUILD_DIR
/bin/rm -f .manifest.txt