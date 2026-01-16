SUMMARY = "AiO screenshot grabber"
MAINTAINER = "PLi team"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "jpeg libpng zlib"

inherit gitpkgv autotools pkgconfig

PV = "1.2+git"
PKGV = "1.2+git${GITPKGV}"

SRC_URI = "${CODEWEBSITE}/openpli-aio-grab.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

GLIBC_64BIT_TIME_FLAGS:mipsel = ""

EXTRA_OECONF = "ac_cv_prog_c_openmp=-fopenmp"

INSANE_SKIP = "32bit-time"
