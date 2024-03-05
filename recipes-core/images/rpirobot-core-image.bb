SUMMARY = "A console-only image that fully supports the target device hardware, with \
        some modifications for easier management"

LICENSE = "MIT"

inherit core-image

# some useful packages
IMAGE_INSTALL += "vim"
IMAGE_INSTALL += "mc"
IMAGE_INSTALL += "bash"
IMAGE_INSTALL += "i2c-tools"

# ROS package group
IMAGE_INSTALL += "packagegroup-ros-world-humble"

# for connectivity
IMAGE_FEATURES += "ssh-server-openssh"

# pkg management
IMAGE_FEATURES += "package-management"

# distro name
DISTRO = "rpirobot"

