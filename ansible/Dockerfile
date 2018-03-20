FROM centos:7

RUN yum install -y epel-release ansible

WORKDIR /root

COPY roles /root/roles
COPY group_vars /root/group_vars

COPY inventory.ini .
COPY ansible.cfg .
COPY ping.yml .

ENTRYPOINT ["ansible-playbook"]
CMD ["ping.yml"]
