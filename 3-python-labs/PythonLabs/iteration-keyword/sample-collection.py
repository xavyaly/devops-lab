#!/usr/bin/python3

users = {'a':'america','b':'bangalore','c':'calcutta'}

for user,country in users.copy().items():
	if country == 'america':
		del users[user]
