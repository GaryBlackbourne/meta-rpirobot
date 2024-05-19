# Recipe for custom robotic application which contains
# building instructions for the driver package
# containing the hardware controller node.

inherit ros_distro_humble

DESCRIPTION = "USART interface for custom robot hardware"
AUTHOR = "Gergely Koloszar <gergely.koloszar@gmail.com>"
HOMEPAGE = "https://github.com/GaryBlackbourne/ros-rpirobot-driver"
SECTION = "devel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

ROS_BUILD_DEPENDS = ""
ROS_BUILDTOOL_DEPENDS = ""
ROS_EXPORT_DEPENDS = ""
ROS_BUILDTOOL_EXPORT_DEPENDS = ""
ROS_EXEC_DEPENDS = "\
        rclpy \
        ros-rpirobot-interfaces \
        python3-pyserial \
"
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
    python3-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/GaryBlackbourne/ros-rpirobot-driver;branch=master;protocol=https"
SRCREV = "7b781a194ecf986f85a60be5c0c83f20bb8741f3"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}

FILES:${PN} += "\
        /usr/share/ros_rpirobot_driver/* \
"