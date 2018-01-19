# Mailinator

A silly test of some even sillier things i.e. sending email with Java

# Setup

First thing you'll need is a test server.  If you've got an SMTP server lying around and know how to wield it, you're good-to-go.  Otherwise, follow this steps to get a simple local mail server set up on Ubuntu 16.04...other distro/versions like work as well.

_Note: Choose 'Local' mail server at the dconf prompt when install postfix, safer.  For the rest, the defaults are reasonable, tweak if you want._

```
sudo apt update
sudo DEBIAN_PRIORITY=low apt-get install postfix # choose local server
sudo postconf -e 'home_mailbox= Maildir/'
sudo postconf -e 'virtual_alias_maps= hash:/etc/postfix/virtual'
echo "test@example.com $USER" >> sudo tee -a /etc/postfix/virtual
sudo postmap /etc/postfix/virtual
sudo systemctl restart postfix.service 
sudo ufw status # if enabled, open ports or disable
```

You should now have a simple test server.  Next, a test client is useful but not necessary, as you could just `cat` the file in your `~/Maildir` directory...the simple beauty of using Maildir over mbox ;)

For an easy client, do

```
echo 'export MAIL=~/Maildir' | \
    sudo tee -a /etc/bash.bashrc | \
    sudo tee -a /etc/profile.d/mail.sh
source /etc/profile.d/mail.sh # optionally add to your .bashrc
sudo apt-get install s-nail
echo "\nset emptystart\nset folder=Maildir\nset record=+sent" | sudo -a tee /etc/s-nail.rc 
```

Give it a quick test. 

_Note: The "Can't canonicalize 'blah'" is normal because you didn't have a maildir yet.  That's why we did the `set emptystart` above._
```
echo 'init' | mail -s 'init' -Snorecord $USER
ls Maildir/new/
cat Maildir/new/*
```
You should see something that looks like an smpt message.  Congrats!
