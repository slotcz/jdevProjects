CREATE VIEW STB_CURRENT_VERSION_FW AS SELECT stb.id, stb.mac, stb.category, rfw.id, rfw.version. rfw.category
    
FROM stb, register_fw rfw 
    
WHERE stb.category = rfw.category;
