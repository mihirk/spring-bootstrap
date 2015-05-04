sudo pip install pexpect
python docker.py
cd ../
docker build -t registry.giantswarm.io/mihirkh/search ./
docker push registry.giantswarm.io/mihirkh/search
