OPENDREAMBOX_PROJECT ?= "${BPN}"

SRC_URI += "${CODEWEBSITE}/${OPENDREAMBOX_PROJECT}.git;protocol=https;branch=master"

inherit git-project
