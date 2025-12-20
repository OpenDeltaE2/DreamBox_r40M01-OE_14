#!/bin/sh
if mountpoint -q /boot
then
    mount -o remount,rw,compr=none /boot
else
    mount -t jffs2 -o rw,compr=none mtd:boot /boot || mount -t jffs2 -o rw,compr=none mtd:'boot partition' /boot
fi
