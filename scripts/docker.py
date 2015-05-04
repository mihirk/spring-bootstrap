import os
import pexpect
def docker_login():
	username = os.environ['DOCKER_USERNAME']
	password = os.environ['DOCKER_PASSWORD']
	email = os.environ['DOCKER_EMAIL']
	child = pexpect.spawn('docker login')
	child.expect('Username.*:')
	child.sendline(username)
	child.expect('Password.*:')
	child.sendline(password)
	child.expect('Email.*:')
	child.sendline(email)

docker_login()