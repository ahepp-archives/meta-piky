SUMMARY = "plantmon repository"
LICENSE = "CLOSED"

RDEPENDS_${PN} = "bash curl i2c-tools piky-keys"

BRANCH="develop"
SRCREV="4e59c4a100ed5f1b282712ad3c5a7659d6f5c69b"
SRC_URI= " \
    git://git@github.com/ahepp/plantmon;protocol=ssh;branch=${BRANCH} \
    "

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "plantmon-sensor.timer"

W = "${WORKDIR}/git"
do_install() {
    install -d ${D}${bindir} ${D}${systemd_unitdir}/system
    install -m 0644 ${W}/sensor/plantmon-sensor.service ${D}${systemd_unitdir}/system
    install -m 0644 ${W}/sensor/plantmon-sensor.timer ${D}${systemd_unitdir}/system
    install -m 0755 ${W}/sensor/plantmon-sensor ${D}${bindir}
    install -m 0755 ${W}/sensor/plantmon-sensor-read ${D}${bindir}
    install -m 0755 ${W}/sensor/plantmon-sensor-post ${D}${bindir}
    install -m 0755 ${W}/pump/plantmon-pump-enable ${D}${bindir}
    install -m 0755 ${W}/pump/plantmon-pump-set ${D}${bindir}
    install -m 0755 ${W}/pump/plantmon-pump-toggle ${D}${bindir}
}

FILES_${PN} = "${bindir} ${systemd_unitdir}"
