import time
import zmq
import os
context = zmq.Context()
socket = context.socket(zmq.REP)
socket.bind("tcp://*:5555")

while True:
	message = socket.recv()
	file = None
	message = int(message)
	if(message == 1):
	   curFile = 'file1.txt'
	   size = os.stat(curFile).st_size
	   target = open(curFile, 'rb')
	   file = target.read(size)
	if(message == 2):
	   curFile = 'file2.txt'
	   size = os.stat(curFile).st_size
	   target = open(curFile, 'rb')
	   file = target.read(size)
	if(message == 3):
	   curFile = 'file3.txt'
	   size = os.stat(curFile).st_size
	   target = open(curFile, 'rb')
	   file = target.read(size)
	if(message == 4):
	   curFile = 'file4.txt'
	   size = os.stat(curFile).st_size
	   target = open(curFile, 'rb')
	   file = target.read(size)
	print("Received request: %s" % message)
	socket.send(file)

