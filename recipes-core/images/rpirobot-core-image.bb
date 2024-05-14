SUMMARY = "A console-only image that fully supports the target device hardware, with \
        some modifications for easier management, and the ros2-humble core toolset."

LICENSE = "MIT"

inherit core-image

##########################
## System configuration ##
##########################

# distro name
DISTRO = "rpirobot"

##########################
## Tools configureation ##
##########################

# some useful packages
IMAGE_INSTALL += "vim"
IMAGE_INSTALL += "mc"
IMAGE_INSTALL += "bash"
IMAGE_INSTALL += "i2c-tools"

# pkg management, adds opkg
IMAGE_FEATURES += "package-management" 

################
## Networking ##
################

# for ap
IMAGE_INSTALL += "hostapd"
IMAGE_INSTALL += "iptables"
IMAGE_INSTALL += "busybox-udhcpd"

# for connectivity
IMAGE_FEATURES += "ssh-server-openssh" 
IMAGE_FEATURES:remove = "read-only-rootfs"

#######################
## ROS configuration ##
#######################

ROS_DISTRO = "humble"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

# ROS2 openembedded config from bblayers.bb
# Lines from the BblayersConfExtraLines setting:
MCF_DISTRO ?= "ros2"
MCF_SUPPORTED_MACHINES ?= "qemux86 qemux86-64 raspberrypi4 raspberrypi4-64"
MCF_OPENEMBEDDED_VERSION ?= "4.0.13-kirkstone"

# ROS package groups
IMAGE_INSTALL += "ros-core"
# IMAGE_INSTALL += "packagegroup-ros-world-humble" # what is this?


