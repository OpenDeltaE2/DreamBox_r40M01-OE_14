MODULE = "PPanel"
SUMMARY = "PPanel"

require conf/license/license-gplv2.inc
require openplugins-replace-pli.inc
require openplugins-distutils.inc

PACKAGES =+ "${PN}-example"
FILES:${PN}-example = "/etc/ppanel/PPanel_tutorial.xml"
