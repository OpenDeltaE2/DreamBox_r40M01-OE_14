DESCRIPTION = "UpcaleDB/HamsterDB"
LICENSE = "GPL-3.0-only"

LIC_FILES_CHKSUM = "file://COPYING.GPL3;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "boost"

RREPLACES:${PN} = "hamsterdb"
CONFLICTS:${PN} = "hamsterdb"

GIT_SITE = "${@ 'git://gitlab.com/jack2015' if d.getVar('CODEWEBSITE') else 'git://gitee.com/jackgee2021'}"
SRC_URI = "${GIT_SITE}/upscaledb.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit gitpkgv autotools

PV = "2.1.12+git${SRCPV}"
PKGV = "2.1.12+git${GITPKGV}"
