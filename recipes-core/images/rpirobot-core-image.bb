SUMMARY = "A console-only image that fully supports the target device hardware, with \
        some modifications for easier management, and the ros2-humble core toolset."

LICENSE = "MIT"

inherit core-image

##########################
## System configuration ##
##########################

# distro name
DISTRO = "rpirobot"

# locales
IMAGE_LINGUAS = "en-us"
GLIBC_GENERATE_LOCALES = "en_US.UTF-8"

##########################
## Tools configureation ##
##########################

# some useful packages
IMAGE_INSTALL += "vim"
IMAGE_INSTALL += "mc"
IMAGE_INSTALL += "bash"
IMAGE_INSTALL += "i2c-tools"
IMAGE_INSTALL += "tmux"
IMAGE_INSTALL += "screen"

# pkg management, adds opkg
IMAGE_FEATURES += "package-management" 

################
## Networking ##
################

# for ap
# IMAGE_INSTALL += "hostapd"
IMAGE_INSTALL += "wpa-supplicant"
IMAGE_INSTALL += "iptables"
# IMAGE_INSTALL += "busybox-udhcpd"

# for connectivity
IMAGE_FEATURES += "ssh-server-openssh" 
IMAGE_FEATURES:remove = "read-only-rootfs"

#################
## ROS package ##
#################

IMAGE_INSTALL += "python3-pyserial"
IMAGE_INSTALL += "ros-rpirobot-interfaces"
IMAGE_INSTALL += "ros-rpirobot-driver"

# # disable serial consoles for communication with hardware
# # this variable is used to populate inittab in the sysvinit-inittab do_install
# # task (meta/recipes-core/sysvinit/)
# !!!!!!!!!! PUT THIS IN BUILD/CONF/LOCAL.CONF !!!!!!!!!!!
# SERIAL_CONSOLES = ""
# SERIAL_CONSOLES_CHECK = ""
# CMDLINE_SERIAL = ""

#######################
## ROS configuration ##
#######################

# these are moved into bblayers for some reason :(
# ROS_DISTRO = "humble"
# ROS_OE_RELEASE_SERIES = "kirkstone"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

# ROS2 openembedded config from bblayers.bb
# Lines from the BblayersConfExtraLines setting:
MCF_DISTRO ?= "ros2"
MCF_SUPPORTED_MACHINES ?= "qemux86 qemux86-64 raspberrypi4 raspberrypi4-64"
MCF_OPENEMBEDDED_VERSION ?= "4.0.13-kirkstone"

# ROS package groups
IMAGE_INSTALL += "ros-core"
# IMAGE_INSTALL += "packagegroup-ros-world-humble"

IMAGE_INSTALL += "\
        ros-base \
        examples-rclcpp-minimal-action-client \
        examples-rclcpp-minimal-action-server \
        examples-rclcpp-minimal-client \
        examples-rclcpp-minimal-composition \
        examples-rclcpp-minimal-publisher \
        examples-rclcpp-minimal-service \
        examples-rclcpp-minimal-subscriber \
        examples-rclcpp-minimal-timer \
        examples-rclcpp-multithreaded-executor \
        examples-rclpy-executors \
        examples-rclpy-minimal-action-client \
        examples-rclpy-minimal-action-server \
        examples-rclpy-minimal-client \
        examples-rclpy-minimal-publisher \
        examples-rclpy-minimal-service \
        examples-rclpy-minimal-subscriber \
        "
