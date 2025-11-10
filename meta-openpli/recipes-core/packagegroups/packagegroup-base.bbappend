# Patches on packagegroups to remove unwanted items
# Remove alsa-utils-alsamixer

RDEPENDS:packagegroup-base-alsa = "\
    alsa-utils-alsactl \
    ${VIRTUAL-RUNTIME_alsa-state}"

PACKAGES += " \
            ${@bb.utils.contains("DISTRO_FEATURES", "smbfs", "packagegroup-base-smbfs-client", "", d)} \
            ${@bb.utils.contains("DISTRO_FEATURES", "smbfs", "packagegroup-base-smbfs-server", "", d)} \
            ${@bb.utils.contains("DISTRO_FEATURES", "smbfs", "packagegroup-base-samba", "", d)} \
            "

RDEPENDS:packagegroup-base := "${@oe.utils.str_filter_out('packagegroup-base-smbfs', '${RDEPENDS:packagegroup-base}', d)}"

RDEPENDS:packagegroup-base-smbfs += "\
    cifs-utils \
    "

RDEPENDS:packagegroup-base-smbfs-client = "\
    packagegroup-base-smbfs \
    smbclient \
    "

RDEPENDS:packagegroup-base-smbfs-server = "\
    samba \
    "

RRECOMMENDS:packagegroup-base-samba = "\
    packagegroup-base-smbfs-client \
    packagegroup-base-smbfs-server \
    "
