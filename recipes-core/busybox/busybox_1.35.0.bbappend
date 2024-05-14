# Add configuration for busybox-udhcp

FILESEXTRAPATHS:prepend := "${THISDIR}/busybox:"

SRC_URI += "file://udhcpd.conf"

do_install:append(){
install -m 0644 ${WORKDIR}/udhcpd.conf ${D}${sysconfdir}/udhcpd.conf

mkdir -p ${D}/var/lib/misc
touch ${D}/var/lib/misc/udhcpd.leases
}

FILES:${PN} += "${sysconfdir}/udhcp.conf"
FILES:${PN} += "$/var/lib/misc/udhcp.leases"
