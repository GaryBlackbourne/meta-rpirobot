
FILESEXTRAPATHS:prepend := "${THISDIR}/wpa-supplicant:"
SRC_URI += " file://wpa_supplicant.conf-sane.patch;patchdir=${WORKDIR}"
