FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://gitee.com/jackgee2021/e2fsprogs.git;protocol=https;branch=master \
	file://Revert-mke2fs-enable-the-metadata_csum.patch \
"

PACKAGE_NO_LOCALE = "1"
