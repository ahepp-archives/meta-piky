include recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += " \
    autoap \
    avahi-daemon \
    avahi-utils \
    kernel-modules \
    linux-firmware-bcm43430 \
    opkg \
    piky-keys \
    piky-update \
    piky-version \
    plantmon \
	"

IMAGE_FEATURES += "ssh-server-openssh"
