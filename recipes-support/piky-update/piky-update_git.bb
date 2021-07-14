SUMMARY = "piky-update repository"
LICENSE = "CLOSED"

RDEPENDS_${PN} = "bash curl piky-keys"

BRANCH="develop"
SRCREV="a84372b55718173f22aa6557894fd2f2be4024fb"
SRC_URI= " \
    git://git@github.com/ahepp/piky-update;protocol=ssh;branch=${BRANCH} \
    file://piky-update.service \
    "

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "piky-update.service"

W = "${WORKDIR}/git"
do_install() {
    install -d ${D}${bindir} ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/piky-update.service ${D}${systemd_unitdir}/system
    install -m 0755 ${W}/piky-update ${D}${bindir}
    install -m 0755 ${W}/piky-update-get ${D}${bindir}
    install -m 0755 ${W}/piky-update-extract ${D}${bindir}
}

FILES_${PN} = "${bindir} ${systemd_unitdir}"
