OPENDREAMBOX_PROJECT ?= "${BPN}"

SRC_URI += "git://gitee.com/jackgee2021/${OPENDREAMBOX_PROJECT}.git;protocol=https;branch=master"

inherit git-project
