SUMMARY = "Multi boot loader manager for enigma2 box"
HOMEPAGE = "https://github.com/Dima73/pli-openmultibootmanager"
LICENSE = "PD"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

RDEPENDS:${PN} = "python-subprocess mtd-utils mtd-utils-ubifs openmultiboot"
RRECOMMENDS:${PN} = "kernel-module-nandsim kernel-module-block2mtd"
inherit gitpkgv distutils-openplugins
PV = "4.0+git${SRCPV}"
PKGV = "4.0+git${GITPKGV}"

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP:${PN}:append = " already-stripped"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "${CODEWEBSITE}/pli-openmultibootmanager.git;protocol=https;branch=master-next"
SRC_URI:dm900 = "${CODEWEBSITE}/pli-openmultibootmanager.git;protocol=https;branch=dm900"
SRC_URI:dm920 = "${CODEWEBSITE}/pli-openmultibootmanager.git;protocol=https;branch=dm900"

SRC_URI += " \
	file://nfidump_mipsel_0.4.2 \
	file://nfidump_mipsel_1.0.0 \
	file://nfidump_mipsel_2.0.0 \
	"

FILES:${PN}:append = " /usr/sbin /sbin"
NFINAME:dm7020hd = "nfidump_mipsel_1.0.0"
NFINAME:dm7020hdv2 = "nfidump_mipsel_1.0.0"
NFINAME:dm8000 = "nfidump_mipsel_1.0.0"
NFINAME:dm500hdv2 = "nfidump_mipsel_1.0.0"
NFINAME:dm800sev2 = "nfidump_mipsel_1.0.0"
NFINAME:dm500hd = "nfidump_mipsel_0.4.2"
NFINAME:dm800se = "nfidump_mipsel_0.4.2"
NFINAME:dm800 = "nfidump_mipsel_0.4.2"
NFINAME:dm820 = "nfidump_mipsel_2.0.0"
NFINAME:dm520 = "nfidump_mipsel_2.0.0"
NFINAME:dm7080 = "nfidump_mipsel_2.0.0"

S = "${WORKDIR}/git"

do_compile() {
    python2 -O -m compileall ${S}
}

do_install:append() {
    install -d ${D}/sbin
    cp ${S}/src/open-multiboot-branding-helper.py ${D}/sbin
    find ${D}/ -name '*.sh' -exec chmod a+x {} \;
    find ${D}/ -name '*.py' -exec rm {} \;
    cp ${S}/src/open-multiboot-branding-helper.py ${D}/usr/lib/enigma2/python/Plugins/Extensions/OpenMultiboot
    install -d ${D}/usr/sbin
}

do_install:append:mipsel() {
    install -m 0755 ${WORKDIR}/${NFINAME} ${D}/usr/sbin/nfidump
}

pkg_preinst:${PN}() {
#!/bin/sh
if mountpoint -q ${libdir}/enigma2/python/Plugins/Extensions/OpenMultiboot; then
    echo "openMultiBoot will only install on main image."
    echo "Child image is running - canceling installation!"
    sleep 3
    exit 1
else
    echo "Main image is running - proceeding installation..."
    exit 0
fi
}

pkg_postrm:${PN}() {
#!/bin/sh

if mountpoint -q ${libdir}/enigma2/python/Plugins/Extensions/OpenMultiboot; then
    echo "openMultiBoot will only remove on main image."
    exit 0
else
    echo "Main image is running - proceeding removing..."
fi

rm -f /sbin/init
ln -sf /sbin/init.sysvinit /sbin/init
rm -f /sbin/open-multiboot-branding-helper.py

chown -Rh root:root ${libdir}/enigma2/python/Plugins/Extensions/OpenMultiboot
rm -rf ${libdir}/enigma2/python/Plugins/Extensions/OpenMultiboot
exit 0

}
