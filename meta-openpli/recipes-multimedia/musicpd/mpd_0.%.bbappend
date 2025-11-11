FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "0.24.6"

DEPENDS:remove = "boost"

SRCREV = "c426749d4709e8d4ec4a6808c004625fae37b60d"

SRC_URI += " \
        file://mpd.conf \
        file://mpd.init \
        "

do_install:append() {
    install -d ${D}${localstatedir}/lib/mpd/playlists
    install -d ${D}${sysconfdir}/init.d
    install -m 755 ${WORKDIR}/mpd.init ${D}${sysconfdir}/init.d/mpd
    install -m 644 ${WORKDIR}/mpd.conf ${D}${sysconfdir}/mpd.conf
}
