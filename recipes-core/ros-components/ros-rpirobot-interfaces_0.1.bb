# Recipe for custom robotic application which contains
# building instructions for package containing the
# interfaces for the project.

inherit ros_distro_humble

DESCRIPTION = "USART interface for custom robot hardware"
AUTHOR = "Gergely Koloszar <gergely.koloszar@gmail.com>"
HOMEPAGE = "https://github.com/GaryBlackbourne/ros-rpirobot-driver"
SECTION = "devel"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"


ROS_BUILD_DEPENDS = "rclcpp-components"
ROS_BUILDTOOL_DEPENDS = "\
        rclcpp \
        rosidl-default-generators-native \
        ament-cmake-native \
        "
ROS_EXPORT_DEPENDS = ""
ROS_BUILDTOOL_EXPORT_DEPENDS = ""
ROS_EXEC_DEPENDS = "\
    rosidl-default-runtime \
"
ROS_TEST_DEPENDS = " \
        ament-lint-common \
        ament-lint-auto \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/GaryBlackbourne/ros-rpirobot-interfaces;branch=master;protocol=https"
SRCREV = "03326671ad3dcda80ef47c25e30e2a33aef3168c"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

# magic to bypass quality assurance
INSANE_SKIP_${PN} += " ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

FILES:${PN} += "\
        /usr/share/ros_rpirobot_interfaces/* \
        /usr/lib/python3.10/site-packages/ros_rpirobot_interfaces/* \
"

# FILES:${PN}-dev += "\
#         /usr/share/ros_rpirobot_interfaces/* \
#         /usr/lib/python3.10/site-packages/ros_rpirobot_interfaces/* \
#         ${includedir} \
# "