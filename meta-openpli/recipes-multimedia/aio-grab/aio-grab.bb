SUMMARY = "AiO screenshot grabber"
MAINTAINER = "PLi team"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "jpeg libpng zlib"

inherit gitpkgv autotools pkgconfig

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

GIT_SITE = "${@ 'git://gitlab.com/jack2015' if d.getVar('CODEWEBSITE') else 'git://gitee.com/jackgee2021'}"
SRC_URI = "${GIT_SITE}/aio-grab.git;protocol=https;branch=master"
SRC_URI:dm800se = "${GIT_SITE}/openpli-aio-grab.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

EXTRA_OECONF = "ac_cv_prog_c_openmp=-fopenmp"
