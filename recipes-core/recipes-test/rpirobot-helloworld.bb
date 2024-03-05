SUMMARY = "Simple test recipe for bitbake"
DESCRIPTION = "Simple test recipe for bitbake"
LICENSE = "MIT"

python do_display_banner() {
    bb.plain("Hello World!");
}

addtask display_banner before do_build

