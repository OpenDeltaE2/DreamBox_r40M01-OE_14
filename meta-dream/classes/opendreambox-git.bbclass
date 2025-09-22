OPENDREAMBOX_PROJECT ?= "${BPN}"

SRC_URI += "git://gitlab.com/jack2015/${OPENDREAMBOX_PROJECT}.git;protocol=https;branch=master"

inherit git-project
