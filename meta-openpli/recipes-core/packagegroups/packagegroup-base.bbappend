# Patches on packagegroups to remove unwanted items
# Remove alsa-utils-alsamixer

RDEPENDS:packagegroup-base-alsa = "\
    alsa-utils-alsactl \
    ${VIRTUAL-RUNTIME_alsa-state}"

PACKAGES += " \
            ${@bb.utils.contains("MACHINE_FEATURES", "smbfs", "packagegroup-base-smbfs-client", "", d)} \
            ${@bb.utils.contains("MACHINE_FEATURES", "smbfs", "packagegroup-base-smbfs-server", "", d)} \
            ${@bb.utils.contains("MACHINE_FEATURES", "smbfs", "packagegroup-base-samba", "", d)} \
            "

RDEPENDS:packagegroup-base-smbfs-client = "\
    cifs-utils \
    smbclient \
    "

RDEPENDS:packagegroup-base-smbfs-server = "\
    samba \
    "

RRECOMMENDS:packagegroup-base-samba = "\
    packagegroup-base-smbfs-client \
    packagegroup-base-smbfs-server \
    "
