# Install Discourse for integration testing
Full tutorial is on [digitalocean](https://www.digitalocean.com/community/tutorials/how-to-install-discourse-on-ubuntu-14-04).
Here's the summary
```
sudo su
mkdir /var/discourse
git clone https://github.com/discourse/discourse_docker.git /var/discourse
cd /var/discourse
cp samples/standalone.yml containers/app.yml

nano containers/app.yml
edit DISCOURS_HOSTNAME,DISCOURSE_DEVELOPER_EMAILS and DISCOURSE_SMTP settings
exit nano

./launcher bootstrap app
```
Voila!