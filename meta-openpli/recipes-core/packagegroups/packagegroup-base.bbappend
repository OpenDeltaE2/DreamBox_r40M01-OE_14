# Patches on packagegroups to remove unwanted items
# Remove alsa-utils-amixer

RDEPENDS:packagegroup-base-alsa = "\
    alsa-utils-alsactl \
    ${VIRTUAL-RUNTIME_alsa-state}"
