<%@page import="com.example.demo.dto.BbsDTO" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.dto.UserDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="css/boardStyles.css" rel="stylesheet"/>
    <link href="css/modal.css" rel="stylesheet"/>
    <script src="js/modal.js"></script>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <script>
        var followData={}
        function followUser(followId) {
            var toUserId = followId;
            console.log("followId " + toUserId);
            $.ajax({
                url: "/follow",
                type: "post",
                dataType: "text",
                data: {
                    "toUserId": toUserId
                },

                success: function (data) {
                    console.log("data: " + data);
                    if (data == 0) {
                        console.log("needlogin");
                        // 로그인이 필요한 경우
                        alert("로그인이 필요합니다.");
                        location.href = "login";
                    } else if (data == 1) {
                        followCount();
                        var modalId = "modal_" + followData.toUserId;
                        $('#' + modalId + ' #follower').text("팔로워 : " + followData.follower);
                        $('#' + modalId + ' #following').text("팔로잉 : " + followData.following);
                    } else if (data == 2) {
                        alert("팔로우 불가능");
                    }
                },
                error: function (error) {
                    // 팔로우 처리 중에 에러가 발생했을 때 실행할 코드
                    console.error("에러가 발생했습니다:", error);
                }
            });
        }

        function followCount() {
            console.log("followCount 함수");
            $.ajax({
                type: "post",
                url: "/followCount",
                success: function (data) {
                    console.log("follower : " + data.follower);
                    console.log("following : " + data.following);
                    followData = data;
                    console.log("followData: ", followData);
                    // $('#follower').text("팔로워 : " + data.follower);
                    // $('#following').text("팔로잉 : " + data.following);
                    // 팔로우 상태를 저장하고 버튼의 텍스트와 href 값을 변경
                    // $('#followButton').attr('href', 'unFollow?toUserId=' + toUserId);
                    // $('#followButton .button').text('언팔로우');
                    // $('#followButton').data('following', true);
                },
                error: function (error) {
                    alert("팔로우 실패하였습니다.");
                }
            });
        }
    </script>
</head>
<div id="layoutSidenav">
    <div id="layoutSidenav_content">
        <main>
            <div class="content-layout">
                <div class="favorites-boards-list">
                    <%
                        ArrayList<BbsDTO> bbsDTOList = (ArrayList) request.getAttribute("bbsDTOList");
                        BbsDTO bbsInfo = new BbsDTO();
                        for (int i = bbsDTOList.size() - 1; i >= 0; i--) {
                            bbsInfo = bbsDTOList.get(i);
                            String modalId = "modal_" + bbsInfo.getUserId();
                    %>
                    <div class="favorites-board-item">
                        <div class="favorites-board-thumbnails">
                            <a class="friend" href="javascript:void(0)"
                               onclick="return openModal('<%=bbsInfo.getUserId()%>')"> <img
                                    class="imgRound"
                                    src="image/profileImage/<%=bbsInfo.getProfileImage()%>"> <%=bbsInfo.getUserId()%>
                            </a>

                            <!-- modal -->
                            <div id="<%=modalId%>" class="modal-background"
                                 onclick="closeModal('<%=bbsInfo.getUserId()%>')">
                                <div class="modal-content">
                                    <div class="card profile-card-1">
                                        <img src="image/profileImage/<%=bbsInfo.getProfileImage()%>"
                                             alt="profile-image" class="profile"/>
                                        <div class="card-content">
                                            <h2 id="followId">
                                                <%=bbsInfo.getUserId()%>
                                            </h2>
                                            <p id="follower" style="display: inline">팔로워 : <%=bbsInfo.getFollower()%>
                                            </p>
                                            <p id="following">팔로잉 : <%=bbsInfo.getFollowing()%>
                                            </p>
                                            <!--<button type="button" class="button"
												onclick="followUser('<%=bbsInfo.getUserId()%>')">팔로우</button>-->
                                            <%--											<a href="follow?followId=<%=bbsInfo.getUserId()%>"><button type="button" class="button" >팔로우</button></a>--%>
                                            <a href="#" id="followButton"
                                               data-following="false">
                                                <button type="button" class="button" onclick="followUser('<%=bbsInfo.getUserId()%>');">팔로우
                                                </button>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <a class="one" href="/bbsOne?bbsId=<%=bbsInfo.getBbsId()%>">
                                <%
                                    if (bbsInfo.getBbsFiles().size() != 0) {
                                        String firstFileName = bbsInfo.getBbsFiles().get(0);
                                %> <img class="favorites-board-image"
                                        src="image/bbsFiles/<%=firstFileName%>"> <%
                            } else {
                            %> <img
                                    class="favorites-board-image"
                                    src="image/bbsFiles/defaultImage.png"> <%
                                }
                            %>
                            </a>
                        </div>
                        <a class="one" href="/bbsOne?bbsId=<%=bbsInfo.getBbsId()%>">
                            <div class="title">
                                <div class="favorites-board-Date"><%=bbsInfo.getBbsDate()%>
                                </div>
                                <div class="favorites-board-heart">♥ 15</div>
                                <div class="favorites-board-title"><%=bbsInfo.getBbsContent()%>
                                </div>
                            </div>
                        </a>
                    </div>
                    <%
                        }
                    %>

                    <a href="/bbsWrite" class="float"> <i class="fa-solid fa-pen"></i>
                    </a>
                </div>
            </div>
        </main>
        <%@include file="footer.jsp" %>
</html>