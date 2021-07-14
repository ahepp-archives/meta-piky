SUMMARY = "piky-version"
LICENSE = "CLOSED"

SRC_URI= "file://version"
do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/version ${D}${sysconfdir}/version
}

FILES_${PN} = "${sysconfdir}"
