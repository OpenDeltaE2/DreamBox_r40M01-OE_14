SUMMARY = "AiO screenshot grabber"
MAINTAINER = "PLi team"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "jpeg libpng zlib"

inherit gitpkgv autotools pkgconfig

TARGET_CC_ARCH:remove = "-D_FILE_OFFSET_BITS=64 -D_TIME_BITS=64"
INSANE_SKIP = "32bit-time"

PV = "1.1+git${SRCPV}"
PKGV = "1.1+git${GITPKGV}"

SRC_URI = "git://gitee.com/jackgee2021/aio-grab.git;protocol=https;branch=master"
SRC_URI:dm800se = "git://gitlab.com/jack2015/openpli-aio-grab.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

EXTRA_OECONF:dm800se = "ac_cv_prog_c_openmp=-fopenmp"
