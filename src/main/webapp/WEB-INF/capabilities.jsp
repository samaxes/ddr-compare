<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <!-- Meta Tags -->
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <title>DDR Compare</title>

        <style>
            table {
                border-collapse: collapse;
                font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
                font-size: 12px;
                text-align: left;
            }

            table thead th {
                background: #e8edff;
                color: #039;
                font-size: 13px;
                font-weight: bold;
                padding: 8px;
            }

            table tbody th {
                background: #b9c9fe;
                border-bottom: 1px solid #fff;
                border-top: 4px solid #aabcfe;
                color: #039;
                font-size: 13px;
                padding: 8px;
            }

            table td {
                background: #e8edff;
                border-bottom: 1px solid #fff;
                border-top: 1px solid transparent;
                color: #669;
                padding: 8px;
                white-space: nowrap;
            }

            table tr:hover td {
                background: #d0dafd;
                color: #339;
            }
        </style>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Property</th>
                    <th>Value</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th colspan="2"><a href="http://wurfl.sourceforge.net/">WURFL</a></th>
                </tr>
                <tr>
                    <td><code>max_image_width</code> <sup>(1)</sup> / <code>max_image_height</code></td>
                    <td>${requestScope.wurflCapability.maxImageWidth} / ${requestScope.wurflCapability.maxImageHeight}</td>
                </tr>
                <tr>
                    <td><code>resolution_width</code> / <code>resolution_height</code></td>
                    <td>${requestScope.wurflCapability.resolutionWidth} / ${requestScope.wurflCapability.resolutionHeight}</td>
                </tr>
                <tr>
                    <th colspan="2"><a href="http://www.openddr.org/">OpenDDR</a></th>
                </tr>
                <tr>
                    <td><code>displayWidth</code> / <code>displayHeight</code></td>
                    <td>${requestScope.openDDRCapability.displayWidth} / ${requestScope.openDDRCapability.displayHeight}</td>
                </tr>
                <tr>
                    <th colspan="2"><a href="http://51degrees.mobi/">51Degrees.mobi</a></th>
                </tr>
                <tr>
                    <td><code>ScreenPixelsWidth</code> / <code>ScreenPixelsHeight</code></td>
                    <td>${requestScope.fiftyoneCapability.screenPixelsWidth} / ${requestScope.fiftyoneCapability.screenPixelsHeight}</td>
                </tr>
            </tbody>
        </table>

        <p><sup>(1)</sup> <code>max_image_width</code> capability is very handy:</p>
        <blockquote cite="http://wurfl.sourceforge.net/help_doc.php">
            Width of the images viewable (usable) width expressed in pixels.
            This capability refers to the image when used in "mobile mode", i.e. when the page is served as XHTML MP,
            or it uses meta-tags such as "viewport", "handheldfriendly", "mobileoptimised" to disable "web rendering"
            and force a mobile user-experience.
        </blockquote>
    </body>
</html>
