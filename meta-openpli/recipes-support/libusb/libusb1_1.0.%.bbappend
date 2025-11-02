# Don't configure udev by default since it will cause a circular
# dependecy with udev package, which depends on libusb

PACKAGE_ARCH = "${MACHINE_ARCH}"
PACKAGECONFIG:class-target = ""
