SUMMARY = "piky-keys repository"
LICENSE = "CLOSED"

BRANCH="master"
SRCREV="66603ed238008909b0da5c9e30498590581e44d2"
SRC_URI= "git://git@github.com/ahepp/piky-keys;protocol=ssh;branch=${BRANCH}"

W = "${WORKDIR}/git"
do_install() {
    install -d ${D}/usr/share/piky
    install -m 0644 ${W}/piky-private.pem ${D}/usr/share/piky
    install -m 0644 ${W}/adafruit-io-secrets.env ${D}/usr/share/piky
}

FILES_${PN} = "/usr/share/piky"

