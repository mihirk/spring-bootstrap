import os
import pexpect
def swarm_login():
	username = os.environ['SWARM_EMAIL']
	password = os.environ['SWARM_PASSWORD']
	child = pexpect.spawn('swarm login')
	child.expect('Username.*:')
	child.sendline(username)
	child.expect('Password.*:')
	child.sendline(password)

swarm_login()