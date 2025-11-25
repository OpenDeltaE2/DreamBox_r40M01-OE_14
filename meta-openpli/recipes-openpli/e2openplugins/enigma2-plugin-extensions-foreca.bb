MODULE = "Foreca"
SUMMARY = "Weather forecast for the upcoming 10 days"
require conf/license/license-gplv2.inc

RDEPENDS:${PN} = "python-html"

inherit gitpkgv
PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
PR = "r8"

require openplugins-distutils.inc

FILES:${PN} += "${sysconfdir}/enigma2/Foreca"
CONFFILES:${PN} = "${sysconfdir}/enigma2/Foreca/City.cfg ${sysconfdir}/enigma2/Foreca/Filter.cfg"
