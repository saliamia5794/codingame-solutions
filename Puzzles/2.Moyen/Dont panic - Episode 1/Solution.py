i,t=int,input
_,_,_,a,b,_,_,n=map(i,t().split())
e={a:b}
for _ in range(n):f,p=map(i,t().split());e[f]=p 
while 1:f,p,d=t().split();f=i(f);p=i(p);b=(f>-1and((p<e[f]and d=="LEFT")or(e[f]<p and d=="RIGHT")));print("BLOCK"if b else"WAIT")