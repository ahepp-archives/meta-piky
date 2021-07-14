SUMMARY = "autoap repository"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS_${PN} = "bash systemd wpa-supplicant wpa-supplicant-cli"

BRANCH="master"
SRCREV="e9ccfa045710a14a4c252c8f932738587417eb94"
SRC_URI= " \
    git://git@github.com/gitbls/autoAP;protocol=ssh;branch=${BRANCH} \
    file://autoAP.sh \
    file://11-wlan0.network \
    file://12-wlan0AP.network \
    file://wpa-autoap@wlan0.service \
    file://wpa-autoap-restore.service \
    file://autoap-local.sh \
    file://autoAP.conf \
    "

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "wpa-autoap-restore.service"

W = "${WORKDIR}/git"
do_install() {
    install -d ${D}${bindir} ${D}${sysconfdir} ${D}${systemd_unitdir}/system ${D}/etc/systemd/network 
    install -d ${D}/etc/systemd/system/multi-user.target.wants
    install -m 0755 ${WORKDIR}/autoAP.sh ${D}${bindir}
    install -m 0755 ${WORKDIR}/autoap-local.sh ${D}${bindir}
    install -m 0644 ${WORKDIR}/autoAP.conf ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/11-wlan0.network ${D}/etc/systemd/network
    install -m 0644 ${WORKDIR}/12-wlan0AP.network ${D}/etc/systemd/network
    install -m 0644 ${WORKDIR}/wpa-autoap-restore.service ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/wpa-autoap@wlan0.service ${D}${systemd_unitdir}/system
    cd ${D}
    ln -s ${systemd_unitdir}/system/wpa-autoap@wlan0.service \
        etc/systemd/system/multi-user.target.wants/wpa-autoap@wlan0.service
}

FILES_${PN} = "${bindir} ${systemd_unitdir} ${sysconfdir}"
