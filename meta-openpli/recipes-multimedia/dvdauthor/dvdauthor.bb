SUMMARY = "create DVD-Video file system"
SECTION = "console/multimedia"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "bison-native fontconfig freetype libdvdread fribidi libpng libxml2 zlib"

GIT_SITE = "${@ 'git://gitlab.com/jack2015' if d.getVar('CODEWEBSITE') else 'git://gitee.com/jackgee2021'}"
SRC_URI = "${GIT_SITE}/dvdauthor.git;protocol=https;branch=master \
	file://fix-build.patch"

inherit gitpkgv
PV = "0.7.2+git${SRCPV}"
PKGV = "0.7.2+git${GITPKGV}"

S = "${WORKDIR}/git"

do_configure:prepend() {
	mkdir -p ${S}/autotools
	cp ${STAGING_DATADIR_NATIVE}/gettext/config.rpath ${S}/autotools/
}

inherit autotools gettext pkgconfig

EXTRA_OECONF = " \
	ac_cv_prog_MAGICKCONFIG= \
	ac_cv_prog_GMAGICKCONFIG= \
"
