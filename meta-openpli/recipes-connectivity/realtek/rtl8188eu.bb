DESCRIPTION = "Driver for Realtek USB wireless devices"
HOMEPAGE = "http://www.realtek.com/"
SECTION = "kernel/modules"
require conf/license/license-gplv2.inc

inherit module machine_kernel_pr

GIT_SITE = "${@ 'git://gitlab.com/jack2015' if d.getVar('CODEWEBSITE') else 'git://gitee.com/jackgee2021'}"
SRC_URI = "${GIT_SITE}/rtl8188eu.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

MACHINE_KERNEL_PR:append = ".0"

EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR}"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
	install -m 0644 ${S}/8188eu.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}

