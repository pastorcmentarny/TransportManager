import platform

pc = "DOM-DESKTOP"
server_port = 18002


def get_path():
    if platform.node() == pc:
        return r'B:\GitHub\TransportManager\db\stations.txt'
    else:
        return r'/home/pi/stations.txt'
