sudo apt-get update
sudo apt-get install -y net-tools
sudo apt install -y iputils-ping
pip install -y httpie

curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -y -o root -g root -m 0755 kubectl /usr/local/bin/kubectl

# 처음만
# curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "../awscliv2.zip"
# unzip ../awscliv2.zip -d ../
# sudo .././aws/install

curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin

curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash
. ~/.nvm/nvm.sh
nvm install -y 14.19.0 && nvm use 14.19.0
export NODE_OPTIONS=--openssl-legacy-provider

cd infra
docker-compose up
