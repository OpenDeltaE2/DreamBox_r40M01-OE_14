FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://git.kernel.org/pub/scm/fs/ext2/e2fsprogs.git;protocol=https;branch=master"
SRC_URI:append = "file://Revert-mke2fs-enable-the-metadata_csum.patch"

PACKAGE_NO_LOCALE = "1"
