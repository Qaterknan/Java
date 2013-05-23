from math import sqrt

primes = [2]
maxPrime = 400000

is_prime = True
i = 3
while i < maxPrime:
	i+=2;
	is_prime = True
	sq = sqrt(i)
	for p in primes:
		if p > sq:
			break
		if i % p == 0:
			is_prime = False
	if is_prime:
		primes.append(i)

print(primes)