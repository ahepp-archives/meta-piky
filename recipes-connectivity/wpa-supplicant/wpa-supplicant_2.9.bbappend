FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "file://wpa_supplicant-wlan0.conf"

inherit systemd
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "wpa_supplicant@wlan0.service"

do_install_append() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0644 ${WORKDIR}/wpa_supplicant-wlan0.conf ${D}${sysconfdir}/wpa_supplicant
}

FILES_${PN} += "${sysconfdir}"
