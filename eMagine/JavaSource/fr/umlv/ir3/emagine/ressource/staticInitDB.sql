CREATE OR REPLACE VIEW userroleview AS 
	SELECT u.login, r.name AS right_name
	  FROM applicationuser u, profile p, rightapplication r, profile_rightapplication pr
	  WHERE u.profile_id = p.id AND p.id = pr.profile_id AND r.id = pr.rights_id;
ALTER TABLE userroleview OWNER TO "eMagine";
