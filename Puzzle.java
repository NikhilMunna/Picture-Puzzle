var ps = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16];
		var address = ["Resoruces/AlienwareLogo",
				"Resoruces/UbiLogo",
				"Resoruces/Ryzen",
				"Resoruces/Razer",
				"Resoruces/Vulkan"
				];
		var da = ["Established in 1995 as Sakai of Miami, Inc. by Nelson Gonzalez and Alex Aguila, Alienware assembles desktops, notebooks, workstations, and PC gaming consoles. According to employees, the name Alienware was chosen because of the founders' fondness for the hit television series The X-Files, which also inspired the science-fiction themed names of product lines such as Area-51, Hangar 18, and Aurora. In 1997, it changed its name to Alienware.",
				"Ubisoft Entertainment SA formerly Ubi Soft Entertainment Software) is a French video game publisher, headquartered in Rennes. It is known for publishing games for several acclaimed video game franchises including Assassin's Creed, Far Cry, Just Dance, Prince of Persia, Rayman, and Tom Clancy's. It is the fourth largest publicly-traded game company in the Americas and Europe after Activision Blizzard, Electronic Arts, and Take-Two Interactive in terms of revenue and market capitalization.",
				"Ryzen is a brand of central processing units (CPUs) and accelerated processing units (APUs) marketed and designed by AMD. The brand was introduced in 2017 with products implementing the Zen microarchitecture.",
				"Razer Inc. (stylized as RΛZΞR), is a Singaporean gaming hardware company founded by Min-Liang Tan and Robert Krakoff, with headquarters in Singapore and San Francisco, and listed in Hong Kong since November 2017, specializing in computer hardware marketed specifically to gamers. Razer is dedicated to the creation and development of products mainly focused on PC gaming such as laptops, tablet computers, various PC peripherals, wearables, and accessories. The Razer brand is currently being marketed under Razer USA Ltd.",
				"Vulkan is a low-overhead, cross-platform 3D graphics and compute API. Vulkan targets high-performance realtime 3D graphics applications such as video games and interactive media across all platforms. Compared with OpenGL and Direct3D 11, and like Direct3D 12 and Metal, Vulkan is intended to offer higher performance and more balanced CPU/GPU usage. Other major differences from Direct3D 11 (and prior) and OpenGL are Vulkan being a considerably lower level API and offering parallel tasking. Vulkan also has the ability to render 2D graphics applications, however it is generally suited for 3D. In addition to its lower CPU usage, Vulkan is also able to better distribute work amongst multiple CPU cores."
				];
		var r = 0;
		function ChangeR()
		{
			r = (r + 1)%5;
		}
		function randamize()
		{
			var i;
			for(i=0;i<20;i++)
			{
				var num1 = Math.floor(Math.random()*16);
				var num2 = Math.floor(Math.random()*16);
				var temp = ps[num1];
				ps[num1] = ps[num2];
				ps[num2] = temp;
			}
		}
		function win()
		{
			var a;
			for(a=0;a<16;a++)
			{
				if(ps[a]!=a+1)
					break;
			}
			if(a==16)
				window.alert("Congratulations!!You Completed the game.");
		}
		randamize();
		function fill()
		{
			var temp = document.getElementById("table1").getElementsByTagName("img");
			var i;
			for(i=0;i<16;i++)
			{
				temp[i].src = address[r] + "/image_part_"+ ps[i] +".jpg";
			}
			document.getElementById("Dummy").src = address[r] + ".jpg";
			document.getElementById("more").innerHTML = da[r];
			win();
		}
		function slide(n)
		{
			if(n < 15 & ps[n+1] == 1 & ((n+1)%4)!=0)
			{
				ps[n+1] = ps[n];
				ps[n] = 1;
			}
			else if(n > 0 & ps[n-1] == 1 & (n%4)!=0)
			{
				ps[n-1] = ps[n];
				ps[n] = 1;
			}
			else if(n > 3 & ps[n-4]==1)
			{
				ps[n-4] = ps[n];
				ps[n] = 1;
			}
			else if(n < 12 & ps[n+4]==1)
			{
				ps[n+4] = ps[n];
				ps[n] = 1;
			}
			fill();
		}
		function MoveL()
		{
			var a;
			for(a=0;a<16;a++)
			{
				if(ps[a]==1)
					break;
			}
			if((a%4)!=0)
			{
				ps[a] = ps[a-1];
				ps[a-1] = 1;
			}
			fill();
		}
		function MoveR()
		{
			var a;
			for(a=0;a<16;a++)
			{
				if(ps[a]==1)
					break;
			}
			if(((a+1)%4)!=0)
			{
				ps[a] = ps[a+1];
				ps[a+1] = 1;
			}
			fill();
		}
		function MoveU()
		{
			var a;
			for(a=0;a<16;a++)
			{
				if(ps[a]==1)
					break;
			}
			if(a>3)
			{
				ps[a] = ps[a-4];
				ps[a-4] = 1;
			}
			fill();
		}
		function MoveD()
		{
			var a;
			for(a=0;a<16;a++)
			{
				if(ps[a]==1)
					break;
			}
			if(a<12)
			{
				ps[a] = ps[a+4];
				ps[a+4] = 1;
			}
			fill();
		}
		document.onkeydown = function(e)
		{
			switch (e.keyCode)
			{
				case 37:
					MoveL();
					break;
				case 38:
					MoveU();
					break;
				case 39:
					MoveR('right');
					break;
				case 40:
					MoveD('down');
					break;
			}
		}